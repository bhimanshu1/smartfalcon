@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem
@rem SPDX-License-Identifier: Apache-2.0
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  assetcontract startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and ASSETCONTRACT_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME% 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\assetcontract-1.0.jar;%APP_HOME%\lib\fabric-chaincode-shim-2.2.0.jar;%APP_HOME%\lib\org.everit.json.schema-1.5.1.jar;%APP_HOME%\lib\genson-1.6.jar;%APP_HOME%\lib\fabric-chaincode-protos-2.2.0.jar;%APP_HOME%\lib\commons-cli-1.4.jar;%APP_HOME%\lib\commons-validator-1.5.1.jar;%APP_HOME%\lib\commons-beanutils-1.9.2.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\bcpkix-jdk15on-1.62.jar;%APP_HOME%\lib\bcprov-jdk15on-1.62.jar;%APP_HOME%\lib\classgraph-4.8.47.jar;%APP_HOME%\lib\json-20180813.jar;%APP_HOME%\lib\protobuf-java-util-3.11.1.jar;%APP_HOME%\lib\grpc-netty-1.30.2.jar;%APP_HOME%\lib\grpc-protobuf-1.30.2.jar;%APP_HOME%\lib\grpc-stub-1.30.2.jar;%APP_HOME%\lib\grpc-core-1.30.2.jar;%APP_HOME%\lib\grpc-protobuf-lite-1.30.2.jar;%APP_HOME%\lib\grpc-api-1.30.2.jar;%APP_HOME%\lib\guava-28.2-android.jar;%APP_HOME%\lib\protobuf-java-3.12.0.jar;%APP_HOME%\lib\javax.annotation-api-1.3.2.jar;%APP_HOME%\lib\commons-digester-1.8.1.jar;%APP_HOME%\lib\commons-collections-3.2.2.jar;%APP_HOME%\lib\error_prone_annotations-2.3.4.jar;%APP_HOME%\lib\gson-2.8.6.jar;%APP_HOME%\lib\netty-codec-http2-4.1.48.Final.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.48.Final.jar;%APP_HOME%\lib\perfmark-api-0.19.0.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.18.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\proto-google-common-protos-1.17.0.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\checker-compat-qual-2.5.5.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\annotations-4.1.1.4.jar;%APP_HOME%\lib\netty-codec-http-4.1.48.Final.jar;%APP_HOME%\lib\netty-handler-4.1.48.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.48.Final.jar;%APP_HOME%\lib\netty-codec-4.1.48.Final.jar;%APP_HOME%\lib\netty-transport-4.1.48.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.48.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.48.Final.jar;%APP_HOME%\lib\netty-common-4.1.48.Final.jar;%APP_HOME%\lib\grpc-context-1.30.2.jar


@rem Execute assetcontract
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %ASSETCONTRACT_OPTS%  -classpath "%CLASSPATH%" org.example.AssetTransfer %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable ASSETCONTRACT_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%ASSETCONTRACT_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
