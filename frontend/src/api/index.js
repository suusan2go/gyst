/* @flow */
import axios from 'axios';
import type { Axios } from 'axios';
import * as urlHelpers from './url';

export default class ApiClient {
  axiosClient: Axios;

  constructor() {
    this.axiosClient = axios.create({
      withCredentials: true,
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

  get(url: string, params: any = {}) {
    return this.axiosClient.get(url, params).then(response => response.data);
  }

  sendDelete(url: string) {
    return this.axiosClient.delete(url).then(response => response.data);
  }

  sendPatch(url: string, data: Object) {
    return this.axiosClient.patch(url, data).then(response => response.data);
  }

  sendPost(url: string, data: Object) {
    return this.axiosClient.post(url, data).then(response => response.data);
  }
}
