pipeline {  
     agent any  
     stages {
        stage('Test') {  
           steps {  
             echo 'hi this is stage'  
             }  
        }
        stage('Test_02') {
            steps {
                echo ' Hi this steps for Test_02'
                error('fake error !')
            }
        }
     }
     post{
        always{
            echo 'Hi this is always '
        }
        success {
            echo 'Hi this is success ! '
        }
        failure {
            echo 'hi this is failure!'
            mail   cc: '', 
                 from: 'Jenkin', 
              replyTo: 'Noreply', 
              subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Something is wrong with ${env.BUILD_URL}", 
                   to: params.email_list
    //        emailext to: params.Email, 
    //                 subject: 'PDI build failed. $PROJECT_NAME - #$BUILD_NUMBER',
    //                 body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}' 

         }  
     }
 
}
