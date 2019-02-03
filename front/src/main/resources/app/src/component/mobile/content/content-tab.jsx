import React, { Component } from 'react';
import {withRouter, Link, Redirect} from "react-router-dom";
import { includes as _includes } from 'lodash';

class ContentTab extends Component {

    CATEGORY = [
        {"name": "홈", "path": "home"},
        {"name": "아티스트", "path": "artist"},
        {"name": "앨범", "path": "album"},
    ];

    linkClassName = (path) => {
        return _includes(this.props.location.pathname, path)
            ? "sb on"
            : "sb";
    };

    render() {
        if (this.props.location.pathname === "/") {
            return (<Redirect to={'/' + this.CATEGORY[0].path}/>)
        }

        return (
            <div className="tab_wrap">
                <ul className="tab_lst">
                    {this.CATEGORY.map((category, i) => {
                            return (
                                <li className={this.linkClassName(category.path)} key={i}>
                                    <Link to={"/" + category.path}>{category.name}</Link>
                                </li>
                            )
                        })
                    }
                </ul>
            </div>
        )
    }
}


export default withRouter(ContentTab);