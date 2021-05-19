import Cookies from 'universal-cookie';
import jwt_decode from "jwt-decode";
import { Redirect } from "react-router"
import React from 'react';
import NavBar from "../components/NavBar"
import PageFooter from "../components/Footer"
import { connect } from 'react-redux';
import { Layout} from 'antd';
const { Content } = Layout;

const cookies = new Cookies();

class Login extends React.Component {
  LoginPage(jwtToken){
    console.log("JWT TOken: ", jwtToken)
    if(!jwtToken){
      console.log("IF condition")
      return(
          <div>
            <NavBar />  
            <Content>
                <div style={{ padding: 24}}>
                  <p>Login Page</p>
                </div>
            </Content>
            <PageFooter/>
          </div>
      );
    }else{
      let decodedJwtToken = jwt_decode(jwtToken);
      const redirectURL = "/"+decodedJwtToken.username;
      return(<Redirect to={redirectURL} />);
    }
  }
  render(){
    return (
      <div>
        {this.LoginPage(cookies.get('token'))}
      </div>
    );
  }
}

// https://stackoverflow.com/a/50225424
const mapStateToProps = (state) => {
  return state.anyJsonReducer;
}

const mapDispatchToProps = (dispatch) => {
  return {}
}

export default connect(mapStateToProps, mapDispatchToProps)(Login);