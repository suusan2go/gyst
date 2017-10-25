/* @flow */
import axios, { AxiosInstance } from 'axios';
import cookie, { CookieSerializeOptions } from 'cookie';
import * as urlHelpers from './url';

export default class ApiClient {
  axiosClient: AxiosInstance;

  constructor() {
    this.axiosClient = axios.create({
      withCredentials: true,
      headers: {
        'X-CSRF-TOKEN': cookie.parse(document.cookie)["X-CSRF-TOKEN"],
      },
    });
    this.axiosClient.interceptors.request.use(
      (config: Object) => config,
      error => Promise.reject(error),
    );
  }

  async getDocuments() {
    const response: Response["body"] = await this.get(urlHelpers.documentsUrl());
    return response;
  }

  async getDocument(id: number) {
    const response: { id: number, title: string, body: string } = await this.get(urlHelpers.documentUrl(id));
    return response;
  }

  async createDocument(value: { title: string, body: string }) {
    const response: {id: number, title: string, body: string} = await this.post(urlHelpers.documentsUrl(), value);
    return response;
  }

  async updateDocument(id: number, value: { title: string, body: string }) {
    const response: {id: number, title: string, body: string} = await this.patch(urlHelpers.documentUrl(id), value);
    return response;
  }

  get(url: string, params: any = {}) {
    return this.axiosClient.get(url, params).then(response => response.data);
  }

  delete(url: string) {
    return this.axiosClient.delete(url).then(response => response.data);
  }

  patch(url: string, data: Object) {
    return this.axiosClient.patch(url, data).then(response => response.data);
  }

  post(url: string, data: Object) {
    return this.axiosClient.post(url, data).then(response => response.data);
  }
}
