interface IQualification{
    qualification: string
}

export function Qualification({qualification}: IQualification){
    return(
        <h1>{qualification}</h1>
    );
}
