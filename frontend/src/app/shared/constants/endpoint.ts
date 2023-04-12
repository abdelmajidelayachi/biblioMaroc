const baseUrl = "http://localhost:8080/api/v1"

export const endpoints = {
  login: `${baseUrl}/auth/login`,
  register: `${baseUrl}/auth/register`,
  // books
  books: `${baseUrl}/books`,
  booksPagination: (page: number, size: number) => `${baseUrl}/books/${page}/${size}`,
  deleteBook: (id: number) => `${baseUrl}/books/${id}`,
  usersPagination: (page: number, size: number) => `${baseUrl}/users/${page}/${size}`,
  // blogs
  blogs: `${baseUrl}/blogs`,
  blogsPagination: (page: number, size: number) => `${baseUrl}/blogs/${page}/${size}`,
}