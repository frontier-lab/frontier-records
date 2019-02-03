import React, { Component } from 'react';



class Header extends Component {

    render() {
        return (
            <div className="header noline">
                <h1 className="logo"><a href="#">AMP</a></h1>
                <ul className="option_btn">
                    <li><a href="#" className="sp search_btn">검색</a></li>
                    <li><a href="#" className="sp alarm_btn">알람<em className="sp">new</em></a></li>
                    <li><a href="#" className="sp slide_btn">슬라이드 메뉴</a></li>
                </ul>
            </div>
        )
    }
}

export default Header;