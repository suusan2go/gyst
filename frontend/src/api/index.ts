import cookie, { CookieSerializeOptions } from 'cookie'
import { DocumentsControllerApi } from './client'

export default class ApiClient {
  client: DocumentsControllerApi = new DocumentsControllerApi({
    basePath: 'http://localhost:8080',
    csrfToken: cookie.parse(document.cookie)["XSRF-TOKEN"],
  })

  async getDocuments() {
    return await this.client.listDocumentsUsingGET()
  }

  async getDocument(id: number) {
    return await this.client.documentUsingGET(id)
  }

  async createDocument(form: { title: string, body: string }) {
    return await this.client.submitDocumentUsingPOST(form);
  }

  async updateDocument(id: number, form: { title: string, body: string },) {
    return await this.client.updateDocumentUsingPATCH(form, id)
  }
}
