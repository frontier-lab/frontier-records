import React, { Component } from 'react'
import Signup from "./signup";


class SignupMain extends Component {
    render() {
        return (
            <div className="wrap signup_cnt">
                <div className="header">
                    <h1 className="h1_tit">회원가입</h1>
                </div>
                <Signup />
            </div>
        )
    }
}

export default SignupMain;