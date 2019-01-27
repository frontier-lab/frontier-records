import Alert from 'react-s-alert';
import 'react-s-alert/dist/s-alert-default.css';
import 'react-s-alert/dist/s-alert-css-effects/bouncyflip.css';

export let defaultAlertOption = {
    position: 'top-right',
    effect: 'bouncyflip',
    timeout: 5000
};

export let info = (msg, option=undefined) => Alert.info(msg, option === undefined? defaultAlertOption: option);
export let error = (msg, option=undefined) => Alert.error(msg, option === undefined? defaultAlertOption: option);
export let warning = (msg, option=undefined) => Alert.warning(msg, option === undefined? defaultAlertOption: option);
export let success = (msg, option=undefined) => Alert.success(msg, option === undefined? defaultAlertOption: option);

