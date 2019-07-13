# stdy-spring-boot-soap-ws

Add o plugin Wizdler no Chrome para testar o Web Service SOAP

# Para visualizar o contrato Wsdl

http://localhost:8080/ws/courses.wsdl

# Para enviar um Post Soap

Acesse o pluging Wizdler na barra de ferramentas e escolha o método 'GetCourseDetails';
Passe o valor 1 na tag <id>;
Clique em 'Go'

# Exemplo

# Request

<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <GetCourseDetailsRequest xmlns="http://stdy-soap.com.br/courses">
            <id>2</id>
        </GetCourseDetailsRequest>
    </Body>
</Envelope>

# Response

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:GetCourseDetailsResponse xmlns:ns2="http://stdy-soap.com.br/courses">
            <ns2:CourseDetails>
                <ns2:id>2</ns2:id>
                <ns2:name>WEB SERVICE SOAP</ns2:name>
                <ns2:description>DESENVOLVENDO WEB SERVICE</ns2:description>
            </ns2:CourseDetails>
        </ns2:GetCourseDetailsResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
