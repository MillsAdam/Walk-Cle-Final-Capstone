import axios from 'axios';

const http = axios.create({
    baseURL: "https://maps.googleapis.com/maps/api/place"
});

export default {
    getPlace() {
        return axios.get('https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=%2B16502530000&inputtype=phonenumber&key=AIzaSyDdqqFWrwPg33CoEoUq8AacD5qyp8gb4ms');
    },
    getGiantEagle() {
        return http.get('/findplacefromtext/json?fields=formatted_address%2Cname%2Crating%2Cplace_id&input=Giant%20Eagle%20Avon%20Lake%20Ohio&inputtype=textquery&key=AIzaSyDdqqFWrwPg33CoEoUq8AacD5qyp8gb4ms');
    }
}