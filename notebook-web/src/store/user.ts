
export const useUserStore = defineStore('user', {
    state: () => ({
        uId: '',
        uName: '',
    }),
    persist:true,
})
