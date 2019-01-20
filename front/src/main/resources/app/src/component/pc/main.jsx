import React, { Component } from 'react';


class Main extends Component {

    render() {
        return (
            <div className="wrap">
                <div className="header">
                    <h1 className="logo"><a href="#">AMP</a></h1>
                    <ul className="gnb_menu">
                        <li className="tv"><a href="#">TV<sup>+</sup></a></li>
                        <li className="story on"><a href="#">스토리</a></li>
                    </ul>
                    <ul className="option_btn">
                        <li className="srch_opt">
                            <div className="srch_inp_box"><input type="text" title="검색어 입력" className="srch_inp"/>
                                <button type="button" className="sp srch_btn">검색하기</button></div>
                            <div className="srch_suggest_layer">
                                <ul>
                                    <li><a href="#" className="keyword">
                                        <mark className="inp_word">다이</mark>
                                        어트</a></li>
                                    <li><a href="#" className="keyword">
                                        <mark className="inp_word">다이</mark>
                                        나믹듀오</a></li>
                                    <li><a href="#" className="keyword">
                                        <mark className="inp_word">다이</mark>
                                        어트운동</a></li>
                                    <li><a href="#" className="keyword">
                                        <mark className="inp_word">다이</mark>
                                        빙</a></li>
                                    <li><a href="#" className="keyword">
                                        <mark className="inp_word">다이</mark>
                                        이어트일기</a></li>
                                    <li><a href="#" className="keyword">
                                        <mark className="inp_word">다이</mark>
                                        어트</a></li>
                                    <li><a href="#" className="keyword">
                                        <mark className="inp_word">다이</mark>
                                        나믹듀오</a></li>
                                    <li><a href="#" className="keyword">
                                        <mark className="inp_word">다이</mark>
                                        소롯데마트갈등발화범다이소</a></li>
                                    <li><a href="#" className="keyword">
                                        <mark className="inp_word">다이</mark>
                                        빙</a></li>
                                    <li><a href="#" className="keyword">
                                        <mark className="inp_word">다이</mark>
                                        이어트일기</a></li>
                                </ul>
                            </div>
                        </li>
                        <li className="alarm_opt">
                            <button type="button" className="sp alarm_btn">알람<em className="sp">new</em></button>
                        </li>
                        <li className="slide_opt">
                            <button type="button" className="sp slide_btn">슬라이드 메뉴</button>
                        </li>
                    </ul>
                </div>
                <div className="container login_cnt">
                    <div className="content">
                        <h3 className="h3_tit"><img src="img/logo_login.png" alt="LOOPIN 세상의 재미를 한눈에" /></h3>
                        <div className="btn_area">
                            <button type="button" className="sp btn_paco_login">페이코로 로그인</button>
                            <button type="button" className="sp btn_facebook_login">페이스북으로 로그인</button>
                        </div>
                        <p className="mem_join">LOOPIN이 처음이신가요? <a href="#">회원가입하기</a></p>
                    </div>
                </div>
            </div>
        );
    }
}

export default Main
