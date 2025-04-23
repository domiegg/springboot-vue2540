const base = {
    get() {
        return {
            url : "http://localhost:8080/yanglaofuwupingtai/",
            name: "yanglaofuwupingtai",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yanglaofuwupingtai/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "养老服务平台"
        } 
    }
}
export default base
