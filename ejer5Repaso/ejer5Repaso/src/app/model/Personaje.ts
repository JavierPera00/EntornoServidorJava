export interface Results{
    results:Personaje[]
}

export interface Personaje{

    id:number,
    name:string,
    status:string,
    species:string,
    image:string,
    episode:string[]

}