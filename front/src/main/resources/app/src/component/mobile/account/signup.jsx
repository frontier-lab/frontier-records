import React, { Component } from 'react';
import { withRouter } from "react-router-dom";
import { isEqual, isEmpty } from 'lodash';
import { validate } from 'email-validator';
import LoginInput from "./login-input";
import SignupTerm from "./signup-term";

import * as Alert from '../../common/alert';
import { register } from '../../common/api/account';
import { checkResultAndRedirect } from '../../common/api/common'

class Signup extends Component {

    initShowErrorGuide = {
        email: false,
        password: false,
        passwordConfirm: false,
        name: false,
    };

    initSignupBtnClass = "btn_join";

    constructor(props) {
        super(props);
        this.state = {
            email:"",
            password: "",
            passwordConfirm: "",
            name: "",
            showErrorGuide: Object.assign({}, this.initShowErrorGuide),
            signupBtnClass: this.initSignupBtnClass

        };
    }

    changeEmail = (value) => this.setState({email: value}, this.validateEmail);
    changeName = (value) => this.setState({name: value}, this.validateName);
    changePassword = (value) => this.setState({password: value}, this.validatePassword);
    changePasswordConfirm = (value) => this.setState({passwordConfirm: value}, this.validatePasswordMatched);

    validateEmail = () => {
        let errorGuide = this.state.showErrorGuide;
        errorGuide.email = isEmpty(this.state.email) || !validate(this.state.email);
        this.setState({showErrorGuide: errorGuide});
        return errorGuide.email;
    };

    validateName = () => {
        let errorGuide = this.state.showErrorGuide;
        errorGuide.name = isEmpty(this.state.name);
        this.setState({showErrorGuide: errorGuide});
        return errorGuide.name;
    }

    validatePassword = () => {
        let errorGuide = this.state.showErrorGuide;
        errorGuide.password = isEmpty(this.state.password) || this.state.password.length < 8;
        this.setState({showErrorGuide: errorGuide});
        return errorGuide.password;
    };


    validatePasswordMatched = () => {
        let errorGuide = this.state.showErrorGuide;
        errorGuide.passwordConfirm = this.state.password !== this.state.passwordConfirm;
        this.setState({showErrorGuide: errorGuide});
        return errorGuide.passwordConfirm;
    };

    validateForm = () => {
        let hasEmailError = this.validateEmail();
        let hasNameError = this.validateName();
        let hasPasswordError = this.validatePassword();
        let hasPasswordMatchedError = this.validatePasswordMatched();
        return hasEmailError || hasNameError || hasPasswordError || hasPasswordMatchedError
    };

    signupBtnClass = () => {
        return isEmpty(this.state.email)
            || isEmpty(this.state.name)
            || isEmpty(this.state.password)
            || isEmpty(this.state.passwordConfirm)
        ? this.initSignupBtnClass
        : this.initSignupBtnClass + " on";
    };

    onSignup = () => {
        if (this.validateForm()) {
            return ;
        }
        register(this.state.email, this.state.password, this.state.name)
        .then(res => res.ok? res.json(): (() => {throw res})())
        .then(res => checkResultAndRedirect(res, "/log-in", this.props.history)
            , err => {console.log(err); Alert.error('알 수 없는 에러가 발생했습니다.')});
    };

    render() {
        return (
            <div>
                <div className="content">
                    <div className="signup_content">
                        <div className="input_area">
                            <p className="tit">아이디</p>
                            <LoginInput inputType="text"
                                        value={this.state.email}
                                        handleChange={this.changeEmail}
                                        showErrorGuide={this.state.showErrorGuide.email}
                                        errorGuide={["한글, 영문, 숫자로 15자리까지 가능합니다.", "정확한 이메일을 입력해 주세요."]}/>
                        </div>
                        <div className="input_area">
                            <p className="tit">비밀번호</p>
                            <LoginInput inputType="password"
                                        value={this.state.password}
                                        handleChange={this.changePassword}
                                        showErrorGuide={this.state.showErrorGuide.password}
                                        errorGuide={["한글, 영문, 숫자로 15자리까지 가능합니다.", "최소 8자리 이상 입력해주세요."]}/>
                        </div>
                        <div className="input_area">
                            <p className="tit">비밀번호 확인</p>
                            <LoginInput inputType="password"
                                        value={this.state.passwordConfirm}
                                        handleChange={this.changePasswordConfirm}
                                        showErrorGuide={this.state.showErrorGuide.passwordConfirm}
                                        errorGuide={["비밀번호가 일치하지 않습니다."]}/>
                        </div>
                        <div className="input_area">
                            <p className="tit">이름</p>
                            <LoginInput inputType="name"
                                        value={this.state.name}
                                        handleChange={this.changeName}
                                        showErrorGuide={this.state.showErrorGuide.name}
                                        errorGuide={["한글, 영문, 숫자로 15자리까지 가능합니다."]}/>
                        </div>
                        <SignupTerm />
                        <a href="#" className={this.signupBtnClass()} onClick={this.onSignup}>회원가입하기</a>
                    </div>
                </div>
            </div>
        )
    }
}

export default withRouter(Signup);