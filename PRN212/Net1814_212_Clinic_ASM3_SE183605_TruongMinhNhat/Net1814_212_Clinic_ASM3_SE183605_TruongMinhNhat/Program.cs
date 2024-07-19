public class Storage
{
    private int _capacity;
    
    public Storage(int initCapacity)
    {
        _capacity = initCapacity;
    }

    private readonly object _lockObject = new();

    public void memoryUsage(int freeSpace)
    {
        Monitor.Enter(_lockObject);
        try
        {
            if (_capacity >= freeSpace)
            {
                Console.WriteLine($"{Thread.CurrentThread.Name} is trying to read Memory Usage {freeSpace}");
                _capacity -= freeSpace;
                Console.WriteLine($"{Thread.CurrentThread.Name} completed the memory. Remaining capacity: {_capacity}");
            }
            else
            {
                Console.WriteLine($"{Thread.CurrentThread.Name} could not read Memory Usage {freeSpace}. Insufficient Capacity.");
            }
            Console.WriteLine();
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message );
        }
        finally 
        {
            Monitor.Exit(_lockObject);
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Storage disk = new Storage(450);

            Thread t1 = new Thread(() => disk.memoryUsage(100)) { Name = "Thread #1" };
            Thread t2 = new Thread(() => disk.memoryUsage(100)) { Name = "Thread #2" };
            Thread t3 = new Thread(() => disk.memoryUsage(100)) { Name = "Thread #3" };
            Thread t4 = new Thread(() => disk.memoryUsage(100)) { Name = "Thread #4" };
            Thread t5 = new Thread(() => disk.memoryUsage(100)) { Name = "Thread #5" };

            t1.Start();
            t2.Start();
            t3.Start();
            t4.Start();
            t5.Start();

            t1.Join();
            t2.Join();
            t3.Join();
            t4.Join();
            t5.Join();

            Console.ReadLine();
        }
    }
}