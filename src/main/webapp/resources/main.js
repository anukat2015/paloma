/**
* The profile creation panel
*/
var CreateProfilePanel = React.createClass({
	/**
	* Handle the profile submission
	*/
	handleSubmit : function (e) {
		e.preventDefault();
		var contact = {
			firstName : $("#firstName").value,
			lastName : this.refs.lastName.value.trim(),
			phoneNumber : this.refs.phone.value.trim(),
			address : this.refs.address.value.trim(),
		};
		$.ajax({
			url : '/paloma/profile',
			type : 'POST',
			data : JSON.stringify(user),
			dataType : 'json',
			success : function(data){
				console.log("Save contact success");
			},
			error : function(message){
				console.error(message);
			}
		});
	},
  render : function () {
    return (
      <form className="form-horizontal" onSubmit={this.handleSubmit}>
        <div className="form-group">
          <label className="col-md-2 control-label" htmlFor="firstName">Surname *</label>
          <input id="firstName" name="firstName" className="col-md-3" type="text" required/>
          <label className="col-md-2 control-label" htmlFor="lastName">Name *</label>
          <input id="lastName" className="col-md-3" type="text" required/>
        </div>
				<div className="form-group">
          <label className="col-md-2 control-label" htmlFor="phone">Phone</label>
          <input id="phone" className="col-md-3" type="text" required/>
          <label className="col-md-2 control-label" htmlFor="address">Adress</label>
          <input id="address" className="col-md-3" type="text"/>
        </div>
				<div className="form-group">
          <label className="col-md-2 control-label" htmlFor="private_mail">Mail (private)</label>
          <input id="private_mail" className="col-md-3" type="text"/>
          <label className="col-md-2 control-label" htmlFor="zip_code">Zipcode</label>
          <input id="zip_code" className="col-md-3" type="text"/>
        </div>
				<div className="form-group">
          <label className="col-md-2 control-label" htmlFor="pro_mail">Mail (pro)</label>
          <input id="pro_mail" className="col-md-3" type="text"/>
          <label className="col-md-2 control-label" htmlFor="city">City</label>
          <input id="city" className="col-md-3" type="text"/>
        </div>
				<div className="form-group">
          <label className="col-md-2 control-label" htmlFor="birthdate">Birthdate</label>
          <input id="birthdate" className="col-md-3" type="text"/>
          <label className="col-md-2 control-label" htmlFor="country">Country</label>
          <input id="country" className="col-md-3" type="text"/>
        </div>
				<div className="form-group">
			    <div className="col-md-offset-2 col-md-10">
			      <button type="submit" className="btn btn-default">Create</button>
			    </div>
			  </div>
      </form>
    );
  }
});

/**
* Notification panel
* @props alertType The type of alert (success, info, warning or danger)
* @props message The message to render
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
	    			<p id="logOut" className="navbar-text clickable" onClick={this.props.logOut}>Log out</p>
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
 * Panel used to manage profile
 */
var ProfilePanel = React.createClass ({
	createProfile : function () {
		return this.props.changeContextViewPanel(<CreateProfilePanel />);
	},
	render : function () {
		return (
			<div className="row">
				<div className="col-md-4 col-md-offset-2 text-center">
					<img className="img-rounded clickable" alt="Create profile"
					src='/paloma/resources/icon/user-add.png'
					onClick={this.createProfile}/>
					<p>Create new profile</p>
				</div>
				<div className="col-md-4 col-md-offset-2">
					<img className="img-rounded clickable" alt="Search profile"
					src='/paloma/resources/icon/user-search.png'/>
					<p>Search profile</p>
					</div>
			</div>
		);
	}
})


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
	* Change the current context view
	*/
	changeContextViewPanel : function (context) {
		this.setState({
			currentContextView : context
		})
	},
	/**
	* Remove the user of the current session
	* of the application
	*/
	logOut: function(event){
		this.setState({
			user : undefined,
			authenticationPanel: <LogInPanel />,
			loggedUserNavItems: "",
			profilePanel: "",
			currentContextView: ""
		});
	},

	buildNotificationPanel : function (alertTypeParam, messageParam) {
		var component = this;
		component.setState({
			notificationPanel : <NotificationPanel alertType={alertTypeParam} message={messageParam} />
		})
	},

	loadLoggedUserView : function () {
		this.setState({
			user : sessionStorage.getItem("user"),
			loggedUserNavItems : <LoggedUserNavItems/>,
			authenticationPanel : <LogOutPanel user={sessionStorage.getItem("user")}
			logOut={this.logOut}/>,
			currentContextView : <ProfilePanel
			changeContextViewPanel={this.changeContextViewPanel} />,
		});
	},
	getInitialState : function(){
		var component = this;
		return {
          authenticationPanel: "",
					loggedUserNavItems: "",
					notificationPanel : "",
					profilePanel : "",
					currentContextView : ""
		};
	},
	componentDidMount: function (){
		var component = this;
		var authenticationCode = this.getUrlParam('code');
		console.log(sessionStorage.getItem("user"));
		if(sessionStorage.getItem("user") != null){
			component.loadLoggedUserView();
		}else if(authenticationCode != undefined) {
			/**
			* Loading the user from Paloma WS
			*/
			$.ajax({
				url : "/paloma/authentication?code=" + authenticationCode,
				dataType : "json",
				success : function(data){
					sessionStorage.setItem("user", data);
					component.loadLoggedUserView();
				},
				error : function () {
					component.setState({
						authenticationPanel : <LogInPanel
						buildNotificationPanel={this.buildNotificationPanel} />,
						notificationPanel : <NotificationPanel alertType="danger"
						message={"Oops. We are unable to get your Google profile. Are \
						you a Palo-IT member ? If you are,	please contact the administrator"} />
					})
				}

			})
		}else{
			component.setState({
				authenticationPanel : <LogInPanel
				buildNotificationPanel={this.buildNotificationPanel} />
			});
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
			{ this.state.currentContextView }
		</div>
		);
	}

});

ReactDOM.render(<MainPanel />, document.getElementById('main'));
