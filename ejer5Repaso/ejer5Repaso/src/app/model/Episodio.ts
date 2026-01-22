export interface Results{
    results:Episodio[]
}

export interface Episodio{
    id:number,
    name:string,
    episode:string,
    characters:string[]
}