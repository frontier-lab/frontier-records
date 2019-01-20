import React, { Component } from 'react';
import LoginInput from './login-input'

class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {
            email:"",
            password: "",
        };

        this.changeEmail = this.changeEmail.bind(this)
        this.changePassword = this.changePassword.bind(this)
    }

    changeEmail(value) {
        console.log('handle change: ', value);
        this.setState({email: value});
    }

    changePassword(value) {
        this.setState({password: value});
    }

    render() {
        return (
            <div>
                <div className="input_area">
                    <p className="tit">아이디</p>
                    <LoginInput inputType="text"
                                value={this.state.email}
                                handleChange={this.changeEmail}
                                errorGuide={<li className="error">한글, 영문, 숫자로 15자리까지 가능합니다.</li>}/>
                </div>
                <div className="input_area">
                    <p className="tit">비밀번호</p>
                    <LoginInput inputType="password"
                                value={this.state.password}
                                handleChange={this.changePassword}
                                errorGuide={<li className="error">한글, 영문, 숫자로 15자리까지 가능합니다.</li>}/>
                </div>
                <div className="btn_area">
                    <button type="button" className="sp btn_login">로그인</button>
                    <button type="button" className="sp btn_paco_login">페이코로 로그인</button>
                    <button type="button" className="sp btn_facebook_login">페이스북으로 로그인</button>
                </div>
            </div>

        );
    }
}

export default  Login;