interface IName{
    name: string
}

export function Name({name}: IName){
    return(
        <h1>{name}</h1>
    );
}
