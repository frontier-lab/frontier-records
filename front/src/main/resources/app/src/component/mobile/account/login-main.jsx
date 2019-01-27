import React, { Component } from 'react'
import { withRouter } from "react-router-dom";

import Login from "./login";


class LoginMain extends Component {
    render() {
        return (
            <div className="wrap">
                <Login />
            </div>
        )
    }
}

export default LoginMain;