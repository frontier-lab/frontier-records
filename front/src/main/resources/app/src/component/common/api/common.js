import * as Alert from '../alert';


export let checkResultAndRedirect = (result, url, history) => {
    if (result.successful) {
        Alert.info(result.message, Alert.defaultAlertOption);
        history.push(url);
    } else {
        Alert.error(result.message);
    }
};