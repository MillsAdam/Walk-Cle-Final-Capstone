import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000'
})
export default{
    getAllLocations(){
        return http.get('/locations/${locationTypeName}')
    },
    getAllStadiums(){
        return axios.get('http://localhost:9000/locations/Stadiums')
    },
    getLocations() {
        return http.get('/locations')
    },
    getLocationTypes() {
        return http.get('/locationtypes')
    },
    getLocation(locationId) {
        return http.get(`/locations/id/${locationId}`)
    }

}