
/**
* Notification panel
* @props alertType The type of alert (success, info, warning or danger)
*/
var NotificationPanel = React.createClass ({
	render: function () {
		return (
			<div className={'alert alert-' + this.props.alertType + ' alert-dismissible'} role="alert">
			  <button type="button" className="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			  {this.props.message}
			</div>
		);
	}
})
/**
* The log in panel
*/
var LogInPanel = React.createClass ({
	getInitialState : function () {
		return {
			authenticationUrl : "",
		};
	},
	componentDidMount : function () {
		var component = this;

		var handleError = function () {
				component.props.buildNotificationPanel("danger", "Authentication from \
				Google is unavailable. Please try later or contact the administrator");
		}
		/**
		* Loading the user from Paloma WS
		*/
		$.ajax({
			url : "/paloma/authentication/url",
			type : 'GET',
			dataType : 'text',
			statusCode : {
				500 : handleError
			},
			success : function (data) {
				component.setState({
					authenticationUrl: data
				});

			},
			error : handleError
		});
	},
	render : function () {
		return (
				<ul className="nav navbar-nav navbar-right">
					<li>
						<a className="navbar-brand" href={this.state.authenticationUrl}>
							<img
							src={'http://www.registryvalet.com/graphics/icon_sm_google_plus.png'}/>
						</a>
					</li>
				</ul>
		);
	}
});

/**
* The log out panel
*/
var LogOutPanel = React.createClass ({
	render : function () {
    	return (
    		<ul className="nav navbar-nav navbar-right">
	    		<li>
	    			<p className="navbar-text">Hello {this.props.user.firstName}</p>
	    		</li>
	    		<li>
	    			<p id="logOut" className="navbar-text" onClick={this.props.logOut}>Log out</p>
	    		</li>
    		</ul>

	    )
    }
});

/**
* The nav bar part available for logged users
*/
var LoggedUserNavItems = React.createClass ({
	render : function () {
		return (
			<ul className="nav navbar-nav">
				<li>
					<a href="#">New profile</a>
				</li>
				<li>
					<a href="#">Search</a>
				</li>
			</ul>
		);
	}
})

/**
* The nav bar
*/
var NavBar = React.createClass ({
	render : function () {
		return(
			<nav className="navbar navbar-default">
				<div className="container-fluid">
					<div className="collapse navbar-collapse">
						<ul className="nav navbar-nav">
							<li>
								<a href="#">Home</a>
							</li>
						</ul>
						{this.props.loggedUserNavItems}
						{this.props.authenticationPanel}
					</div>
				</div>
			</nav>
	)}
});

/**
* The root panel
*/
var MainPanel = React.createClass ({
	/**
	 * Function used to find parameter from
	 * get request
	 */
	getUrlParam : function (param) {
		var vars = {};
		window.location.href.replace(
			/[?&]+([^=&]+)=?([^&]*)?/gi,
			function( m, key, value ) {
				vars[key] = value !== undefined ? value : '';
			}
		);
		if ( param ) {
			return vars[param] ? vars[param] : null;
		}
		return vars;
	},
	/**
	* Remove the user of the current session
	* of the application
	*/
	logOut: function(event){
		this.setState({
			user : undefined,
			authenticationPanel: <LogInPanel />,
			loggedUserNavItems: ""
		});
	},

	buildNotificationPanel : function (alertTypeParam, messageParam) {
		var component = this;
		component.setState({
			notificationPanel : <NotificationPanel alertType={alertTypeParam} message={messageParam} />
		})
	},
	getInitialState : function(){
		var component = this;
		return {
          authenticationPanel: <LogInPanel buildNotificationPanel={component.buildNotificationPanel}/>,
					loggedUserNavItems: "",
					notificationPanel : ""
		};
	},
	componentDidMount: function (){
		var component = this;
		var authenticationCode = this.getUrlParam('code');
		if(authenticationCode != undefined && this.user == undefined){
			/**
			* Loading the user from Paloma WS
			*/
			$.ajax({
				url : "/paloma/authentication?code=" + authenticationCode,
				dataType : "json",
				success : function(data){
					component.setState({
						user : data,
						loggedUserNavItems : <LoggedUserNavItems/>,
	          authenticationPanel : <LogOutPanel user={data} logOut={component.logOut}/>
					});
				}
			,
				error : function () {
					component.setState({
						notificationPanel : <NotificationPanel alertType="danger"
						message="Oops. We are unable to get your Google profile. Are
						you a Palo-IT member ? If you are,	please contact the administrator" />
					})
				}

			})
		}
	},
	render: function () {
		return (
		<div className="container-fluid">
			<NavBar authenticationPanel={this.state.authenticationPanel}
			loggedUserNavItems={this.state.loggedUserNavItems}/>

			<div>
				<div className="row">
				<div className="col-md-offset-1 col-md-10">
				</div>
				</div>
			</div>
			<div className="row">
				<div className="col-md-offset-4 col-md-4">
					{this.state.notificationPanel}
				</div>
			</div>
		</div>
		);
	}

});

ReactDOM.render(<MainPanel />, document.getElementById('main'));
