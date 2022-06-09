import { Configuration, DefaultApi } from "./generated-sources/openapi";

export const test = () => {

    const configuration = new Configuration({
        basePath: "http://localhost:8080/v1",

    });
    const baseapi = new DefaultApi(configuration);
    baseapi.usersGet().then(res => {
        console.log(res);
    }).catch(err => console.log(err));

}