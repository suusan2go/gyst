/* @flow */
import axios from 'axios';
import * as urlHelpers from './url';

export default class ApiClient {
  sessionToken: ?string;
  constructor(sessionToken: ?string) {
    this.sessionToken = sessionToken;
    this.axiosClient = axios.create({
      withCredentials: true,
    });
    this.axiosClient.interceptors.request.use(
      (config: Object) => config,
      error => Promise.reject(error),
    );
  }

  async getMemos() {
    const response: Response = await this.get(urlHelpers.memosUrl());
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
