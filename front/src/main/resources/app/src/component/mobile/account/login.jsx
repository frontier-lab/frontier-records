import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom'
import {isEmpty} from "lodash";
import { validate } from 'email-validator'


import LoginInput from './login-input'

import * as Alert from '../../common/alert';
import { login } from '../../common/api/account';
import { checkResultAndRedirect } from "../../common/api/common";

class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {
            email:"",
            password: "",
            emailErrorGuide: false,
            passwordErrorGuide: false
        };
    };

    changeEmail = (value) => this.setState({email: value}, this.validateEmail);
    changePassword = (value) => this.setState({password: value}, this.validatePassword);

    validateEmail = () => {
        let emailError = isEmpty(this.state.email) || !validate(this.state.email)
        this.setState({emailErrorGuide: emailError});
        return emailError;
    }
    validatePassword = () => {
        let passwordError = isEmpty(this.state.password)
        this.setState({passwordErrorGuide: passwordError});
        return passwordError;
    }

    onLogin = () => {
        let emailError = this.validateEmail();
        let passwordError = this.validatePassword();
        if (emailError || passwordError) {
            return ;
        }

        login(this.state.email, this.state.password)
            .then(res => res.ok? res.json(): (() => {throw res})())
            .then(res => checkResultAndRedirect(res, "/", this.props.history)
                , err => {console.log(err); Alert.error('알 수 없는 에러가 발생했습니다.')});
    };

    render() {
        return (
            <div className="login_cnt">
                <div className="content">
                    <h3 className="h3_tit">LOOPIN</h3>
                    <p className="txt">세상의 재미를 한눈에</p>
                    <div className="input_area">
                        <p className="tit">아이디</p>
                        <LoginInput inputType="text"
                                    value={this.state.email}
                                    handleChange={this.changeEmail}
                                    showErrorGuide={this.state.emailErrorGuide}
                                    errorGuide={["정확한 이메일을 입력해 주세요."]}/>
                    </div>
                    <div className="input_area">
                        <p className="tit">비밀번호</p>
                        <LoginInput inputType="password"
                                    value={this.state.password}
                                    handleChange={this.changePassword}
                                    showErrorGuide={this.state.passwordErrorGuide}
                                    errorGuide={["비밀번호를 입력해 주세요."]}/>
                    </div>
                    <div className="btn_area">
                        <button type="button" className="sp btn_login" onClick={this.onLogin}>로그인</button>
                        <button type="button" className="sp btn_paco_login">페이코로 로그인</button>
                        <button type="button" className="sp btn_facebook_login">페이스북으로 로그인</button>
                    </div>
                    <p className="mem_join">Frontier가 처음이신가요? <Link to="sign-up">회원가입하기</Link></p>
                </div>
            </div>
        );
    }
}

export default  withRouter(Login);