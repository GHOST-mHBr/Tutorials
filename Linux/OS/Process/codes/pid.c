#include <unistd.h> //Unix Standard
#include <stdio.h>

int main(){
    printf("Current Process PID: %d",getpid());
    return 0;
}