import React, { Component } from 'react'

import Login from "./login/login";


class Main extends Component {
    render() {
        return (
            <div className="wrap">
                <div className="container login_cnt">
                    <div className="content">
                        <h3 className="h3_tit">LOOPIN</h3>
                        <p className="txt">세상의 재미를 한눈에</p>
                        <Login />
                        <p className="mem_join">Frontier가 처음이신가요? <a href="#">회원가입하기</a></p>
                    </div>
                </div>
            </div>
        )
    }
}

export default Main;