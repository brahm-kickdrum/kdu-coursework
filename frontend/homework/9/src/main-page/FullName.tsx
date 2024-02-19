interface IFullName{
    fullname: string
}

export function FullName({fullname}: IFullName){
    return(
        <h2>{fullname}</h2>
    );
}