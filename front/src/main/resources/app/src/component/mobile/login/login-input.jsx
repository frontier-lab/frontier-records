
import React, { Component } from 'react';

class LoginInput extends Component {

    constructor(props) {
        super(props);

        this.INPUT_NORMAL_CLASS="input_wrap info";
        this.INPUT_FOCUS_CLASS="input_wrap edit";
        this.INPUT_ERROR_CLASS="input_wrap error";

        this.state = {
            inputClass: this.INPUT_NORMAL_CLASS,
            inputType: props.inputType,
            handleChange: props.handleChange
        };

        this.changeClassOnBlur = this.changeClassOnBlur.bind(this);
        this.changeClassOnFocus = this.changeClassOnFocus.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.validateForm = this.validateForm.bind(this);
    }

    validateForm(value) {
        if (value <= 0) {
            this.setState({inputClass: this.INPUT_ERROR_CLASS})
        } else {
            this.setState({inputClass: this.INPUT_FOCUS_CLASS})
        }
    }

    changeClassOnBlur() {
        this.setState({inputClass: this.INPUT_NORMAL_CLASS})
    }

    changeClassOnFocus() {
        this.setState({inputClass: this.INPUT_FOCUS_CLASS})
    }

    handleChange(event) {
        this.validateForm(event.target.value);
        this.state.handleChange(event.target.value);
    }

    render() {
        return (
            <div className={this.state.inputClass}>
                <div className="input_box">
                    <p className="input">
                        <input type={this.state.inputType} name=""
                               onBlur={this.changeClassOnBlur}
                               onFocus={this.changeClassOnFocus}
                               value={this.props.value}
                               onChange={this.handleChange}
                               className="input_email"/>
                    </p>
                </div>
                {this.state.inputClass === this.INPUT_ERROR_CLASS && this.props.errorGuide
                    ? (
                        <ul className="input_guide">
                            {this.props.errorGuide}
                        </ul>
                    )
                    : ("")
                }

            </div>
        )
    }
}

export default LoginInput