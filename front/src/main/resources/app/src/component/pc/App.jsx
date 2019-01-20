import React, { Component } from 'react';

import '../../assets/pc/css/common.css';
import '../../assets/pc/css/member.css'

import Main from './main'
import Dimd from '../common/dimd'

class App extends Component {

    render() {
        return (
            <div>
                <Main/>
                <Dimd/>
            </div>
        )
    }
}

export default App;