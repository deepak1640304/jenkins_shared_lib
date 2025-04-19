def call(String project, String ImageTag, String hubUser){
    withCredentials([usernamePassword(
            credentialsId: "docker",
            usernameVariable: "kurumathi",
            passwordVariable: "dckr_pat_GopndSjbaOoDuXh3BdgsNf82V3w"
    )]) {
        sh "docker login -u '$kurumathi' -p '$dckr_pat_GopndSjbaOoDuXh3BdgsNf82V3w'"
    }
    //sh "docker image push ${hubUser}/${project}:${ImageTag}"
    sh "docker image push ${hubUser}/${project}:latest"   
}


// def call(String aws_account_id, String region, String ecr_repoName){
    
//     sh """
//      aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
//      docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//     """
// }
