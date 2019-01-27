
import React, { Component } from 'react';

class LoginInput extends Component {

    constructor(props) {
        super(props);

        this.INPUT_NORMAL_CLASS="input_wrap info";
        this.INPUT_FOCUS_CLASS="input_wrap edit";
        this.INPUT_ERROR_CLASS="input_wrap error";

        this.state = {
            focused: false,
            inputClass: this.INPUT_NORMAL_CLASS,
        };
    }

    componentWillReceiveProps = (nextProps) => {
        if ( nextProps.showErrorGuide ) {
            this.setState({inputClass: this.INPUT_ERROR_CLASS});
        } else {
            this.changeClass();
        }
    };

    onBlur = () => this.setState({focused: false}, () => this.changeClass());

    onFocus = () => this.setState({focused: true}, () => this.changeClass());

    changeClass = () => {
        if (this.state.focused) {
            this.setState({inputClass: this.INPUT_FOCUS_CLASS})
        } else {
            this.setState({inputClass: this.INPUT_NORMAL_CLASS})
        }
    };

    handleChange = (event) => this.props.handleChange(event.target.value);

    render() {
        return (
            <div className={this.state.inputClass}>
                <div className="input_box">
                    <p className="input">
                        <input type={this.props.inputType} name=""
                               onBlur={this.onBlur}
                               onFocus={this.onFocus}
                               value={this.props.value}
                               onChange={this.handleChange}
                               className="input_email"/>
                    </p>
                </div>
                {this.props.showErrorGuide
                    ? (
                        <ul className="input_guide">
                            {this.props.errorGuide.map((guide, index) =>
                                <li key={index} className="error">{guide}</li>)}
                        </ul>
                    )
                    : ("")
                }

            </div>
        )
    }
}

export default LoginInput