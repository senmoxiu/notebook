

export const useStoreEvent = defineStore('event', {
    state: () => ({
        eId: '',
        title: '',
        cId: '',
        status: 0,
        level: 0,
        startDate:'',
        endDate:'',
        content: '',
    })
})
