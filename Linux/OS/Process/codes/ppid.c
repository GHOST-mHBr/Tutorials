#include <unistd.h> // Unix Standard
#include <stdio.h>

int main(){
    printf("Current Process PPID: %d",getppid());
    return 0;
}