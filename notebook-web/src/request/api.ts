import http from './http';

// GET请求示例
export function get(url: string, params: any) {
    return http.get(url, { params })
        .then(response => {
            // 请求成功处理逻辑
            return response.data;
        })
        .catch(error => {
            // 请求失败处理逻辑
            throw error;
        });
}

// POST请求示例
export function post(url: string, data: any) {
    return http.post(url, data)
        .then(response => {
            // 请求成功处理逻辑
            return response.data;
        })
        .catch(error => {
            // 请求失败处理逻辑
            throw error;
        });
}

// put请求示例
export function put(url: string, data: any) {
    return http.put(url, data)
        .then(response => {
            // 请求成功处理逻辑
            return response.data;
        })
        .catch(error => {
            // 请求失败处理逻辑
            throw error;
        });
}

// delete请求示例
export function deleteRequest(url: string,params: any) {
    return http.delete(url, {params})
        .then(response => {
            // 请求成功处理逻辑
            return response.data;
        })
        .catch(error => {
            // 请求失败处理逻辑
            throw error;
        });
    }
