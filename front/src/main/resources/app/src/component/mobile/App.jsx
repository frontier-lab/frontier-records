import React, { Component } from 'react';
import { BrowserRouter, Route } from 'react-router-dom'

import '../../assets/mobile/css/common.css';
import '../../assets/mobile/css/member_test.css'

import Router from './router';
import Dimd from '../common/dimd';

class App extends Component {

    render() {
        return (
            <div>
                <BrowserRouter>
                    <Router />
                </BrowserRouter>
                <Dimd/>
            </div>
        )
    }
}

export default App;