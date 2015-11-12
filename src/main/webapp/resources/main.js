var LogInPanel = React.createClass ({
	getInitialState : function () {
		return {
			authenticationUrl : ""
		};
	},
	componentDidMount : function () {
		var component = this;
		$.get("/paloma/authentication/url", function (data) {
			component.setState({
				authenticationUrl: data
			});
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

var LogOutPanel = React.createClass ({
    render : function () {
    	return (
    		<ul className="nav navbar-nav navbar-right">
	    		<li>
	    			<p className="navbar-text">Hello {this.props.user.firstName}</p>
	    		</li>
	    		<li>
	    			<a href="#">Log out</a>
	    		</li>
    		</ul>
	        
	    )
    }
});

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
							<li>
								<a href="#">New profile</a>
							</li>
							<li>
								<a href="#">Search</a>
							</li>
						</ul>
						{this.props.authenticationPanel}
					</div>
				</div>
			</nav>
	)}
});

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
	getInitialState : function(){
		return {
            authenticationPanel: <LogInPanel />
		};
	},
	componentDidMount: function (){
		var component = this;
		var authenticationCode = this.getUrlParam('code');
		if(authenticationCode != undefined){
			$.get("/paloma/authentication?code=" + authenticationCode,
			function(data){
				component.setState({
					user : data,
                    authenticationPanel : <LogOutPanel user={data}/>
				});
			});
		}
	},
	render: function () {
		return (
		<div className="container-fluid">
			<NavBar authenticationPanel={this.state.authenticationPanel} />
		
			<div>
				<div className="row">
				<div className="col-md-offset-1 col-md-10">
				</div>
				</div>
			</div>
			<div className="row">
				<div className="col-md-offset-4 col-md-4">
				</div>
			</div>
		</div>
		);
	}
	
});

ReactDOM.render(<MainPanel />, document.getElementById('main'));