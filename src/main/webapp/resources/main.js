var AuthenticationButton = React.createClass ({
	render : function () {
		return (
				<a href={'https://accounts.google.com/o/oauth2/auth?client_id=852815160721-odq9kl622hj1pkpa0acrbd2rsii9c59m.apps.googleusercontent.com&redirect_uri=http://localhost:8080/paloma&response_type=code&scope=https://www.googleapis.com/auth/userinfo.profile%20https://www.googleapis.com/auth/userinfo.email&state=google;2025860991'}>
					<img 
					src={'http://www.registryvalet.com/graphics/icon_sm_google_plus.png'}/>
				</a>
		);
	}
});

var NavBar = React.createClass ({
	getInitialState : function(){
		return {
			welcomeMessage : "Welcome on Paloma"
		};
	},
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
						<ul className="nav navbar-nav navbar-right">
							<li>
								<a href="#">Hello {this.props.username}</a>
							</li>
						</ul>
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
	getUrlParam : function(param) {
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
			username : ""
		};
	},
	componentDidMount: function(){
		var component = this;
		var authenticationCode = this.getUrlParam('code');
		if(authenticationCode != undefined){
			console.log("We have authentication code")
			$.get("/paloma/authentication?code=" + authenticationCode,
			function(data){
				console.log("Data is " + data);
				component.setState({
					user : data,
					username : data.firstName
				});
			});
		}
	},
	render: function() {
		return (
		<div className="container-fluid">
			<NavBar username={this.state.username} />
		
			<div>
				<div className="row">
				<div className="col-md-offset-1 col-md-10">
				</div>
				</div>
			</div>
			<div className="row">
				<div className="col-md-offset-4 col-md-4">
					<AuthenticationButton />
				</div>
			</div>
		</div>
		);
	}
	
});

ReactDOM.render(<MainPanel />, document.getElementById('main'));