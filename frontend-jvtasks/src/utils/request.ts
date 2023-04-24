import axios, { AxiosRequestConfig } from "axios";
import { BASE_URL } from "./system";

export function requestBackend(config: AxiosRequestConfig) {

    const headers = config.withCredentials
        ? {
            ...config.headers,
        }
        : config.headers;


    return axios({ ...config, baseURL: BASE_URL, headers });
}