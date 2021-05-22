import React from 'react';
import ResponsiveAntMenu from './ResponsiveAntMenu'
import { Menu } from 'antd';
import { 
    GithubOutlined,
} from '@ant-design/icons';
import { connect } from 'react-redux';
import Cookies from 'universal-cookie';
const cookies = new Cookies();

class NavBar extends React.Component {
  LogoutClickEvent = (e) => {
    e.preventDefault();
    cookies.remove('token', {path: "/", domain: `${process.env.REACT_APP_COOKIE_DOMAIN}`});
    window.location = "/";
  };

  AuthButton() {
    if(this.props.isLoggedInStatus){
      return (
        <Menu.Item style={{float: 'right'}} key='/logout' className={'menu-home'}>
          {// eslint-disable-next-line
          }<a href="#" onClick={this.LogoutClickEvent}>Logout</a>
        </Menu.Item>   
      );

    }else {
      let GithubClientURL = `https://github.com/login/oauth/authorize?client_id=${process.env.REACT_APP_GITHUB_CLIENT_SECRET}&redirect_uri=${process.env.REACT_APP_API_ENDPOINT}/oauth/redirect`;
      /* eslint-disable */
      return (
        <Menu.Item style={{float: 'right'}} key='/oauth/authorize' className={'menu-home'}>
          <a href={GithubClientURL}>Login with github  <GithubOutlined /></a>
        </Menu.Item>
      );
    }
  }
  render(){
    return (
                <ResponsiveAntMenu
                    mobileMenuContent={isMenuShown => isMenuShown ? <button>Close</button> : <button>Open</button>}
                    menuClassName={'responsive-ant-menu'}
                >
                    {(onLinkClick) =>          
                        <Menu theme='dark'>
                            <Menu.Item key='/' className={'menu-home'}>
                                <a onClick={onLinkClick} href={'/'}>GoAnyJSON</a>
                            </Menu.Item>
                            {this.AuthButton()}
                        </Menu>                    
                    }
                </ResponsiveAntMenu>
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

export default connect(mapStateToProps, mapDispatchToProps)(NavBar);



