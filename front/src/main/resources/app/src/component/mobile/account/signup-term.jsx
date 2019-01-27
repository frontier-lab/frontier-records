import React, { Component } from "react";


class SignupTerm extends Component {

    render() {
        return (
            <div className="terms_area">
                {/*<button className="sp btn_allagree"><span className="sp blt_allagree"></span>전체 동의*/}
                {/*</button>*/}
                {/*<ul className="terms_lst">*/}
                    {/*<li className="terms_service">*/}
                        {/*<input type="checkbox" id="termsService" className="chk" />*/}
                        {/*<label htmlFor="termsService" className="on">AMP 서비스이용약관에 동의합니다.<span*/}
                            {/*className="essential">(필수)</span></label>*/}
                        {/*<a href="#" className="terms_view">보기</a>*/}
                    {/*</li>*/}
                    {/*<li className="terms_privacy">*/}
                        {/*<input type="checkbox" id="termsPrivacy" className="chk" />*/}
                        {/*<label htmlFor="termsPrivacy">AMP 개인정보처리방침에 동의합니다.<span*/}
                            {/*className="essential">(필수)</span></label>*/}
                        {/*<a href="#" className="terms_view">보기</a>*/}
                    {/*</li>*/}
                {/*</ul>*/}
            </div>
        )
    }
}

export default SignupTerm;