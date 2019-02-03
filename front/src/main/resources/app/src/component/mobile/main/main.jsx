import React, { Component } from "react";
import { withRouter, Redirect } from "react-router-dom";

import Header from '../nav/header'
import Container from '../content/container'

class Main extends Component {

    render() {
        return (
            <div className="wrap">
                <Header />
                <div className="loading" style={{"display":"none"}}><span>loading</span></div>
                <Container />
            </div>
        )
    }
}

export default withRouter(Main);