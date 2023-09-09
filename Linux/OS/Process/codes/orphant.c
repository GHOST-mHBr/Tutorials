#include <unistd.h>
#include <stdio.h>

int main()
{

    printf("starting...\n");

    if (fork() == 0)
    {
        printf("Child PID: %d\n",getpid());
        printf("Child PPID: %d\n",getppid());
        printf("sleeping till the parent die:(\n");
        sleep(5);
        printf("Child new PPID: %d\n",getppid());
    }
    else
    {
        printf("Parent PID: %d\n",getpid());
    }

    return 0;
}