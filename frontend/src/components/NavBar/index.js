import React from 'react';
import ResponsiveAntMenu from './ResponsiveAntMenu'
import { Menu } from 'antd';
import { 
    GithubOutlined,
  } from '@ant-design/icons';
import { updateIsLoggedInStatus } from "./../../redux/actions";
import { connect } from 'react-redux';

class NavBar extends React.Component {
  AuthButton() {
    if(this.props.isLoggedInStatus){
      <Menu.Item style={{float: 'right'}} key='/oauth/authorize' className={'menu-home'}>
        <a href="https://github.com/login/oauth/authorize?client_id=e4159913c485d2c56c88&redirect_uri=http://localhost:8003/oauth/redirect">Logout</a>
      </Menu.Item>   
    }else {
      return (
        <Menu.Item style={{float: 'right'}} key='/oauth/authorize' className={'menu-home'}>
          <a href="https://github.com/login/oauth/authorize?client_id=e4159913c485d2c56c88&redirect_uri=http://localhost:8003/oauth/redirect">Login with github  <GithubOutlined /></a>
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
  return {
    updateIsLoggedInStatus: (isLoggedInStatus) => dispatch(updateIsLoggedInStatus(isLoggedInStatus))
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(NavBar);

