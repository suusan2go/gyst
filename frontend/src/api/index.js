/* @flow */
import axios from 'axios';
import cookie from 'cookie';
import type { Axios } from 'axios';
import * as urlHelpers from './url';

export default class ApiClient {
  axiosClient: Axios;

  constructor() {
    this.axiosClient = axios.create({
      withCredentials: true,
      headers: {
        'X-CSRF-TOKEN': cookie['XSRF-TOKEN'],
      },
    });
    this.axiosClient.interceptors.request.use(
      (config: Object) => config,
      error => Promise.reject(error),
    );
  }

  async getDocuments() {
    const response: Response = await this.get(urlHelpers.documentsUrl());
    return response;
  }

  async getDocument(id: number) {
    const response: Response = await this.get(urlHelpers.documentUrl(id));
    return response;
  }

  async createDocument(value: { title: string, body: string }) {
    const response: Response = await this.post(urlHelpers.documentsUrl(), value);
    return response;
  }

  async updateDocument(id: number, value: { title: string, body: string }) {
    const response: Response = await this.patch(urlHelpers.documentUrl(id), value);
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
