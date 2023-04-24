import axios, { AxiosRequestConfig } from "axios";
import { requestBackend } from "../utils/request";

export function findPageRequest(page: number, name: string, size = 12, sort = 'name') {
    const config: AxiosRequestConfig = {
        method: 'GET',
        url: '/tasks',
        params: {
            page,
            name,
            size,
            sort
        }
    }

    return requestBackend(config);
}