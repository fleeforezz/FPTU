﻿// <auto-generated> This file has been auto generated by EF Core Power Tools. </auto-generated>
#nullable disable
using System;
using System.Collections.Generic;

namespace Net1814_212_ASM3_SE183605_TruongMinhNhat.Models;

public partial class Record
{
    public int RecordId { get; set; }

    public int ClinicId { get; set; }

    public int CustomerId { get; set; }

    public int NumOfVisits { get; set; }

    public virtual Clinic Clinic { get; set; }

    public virtual Customer Customer { get; set; }

    public virtual ICollection<RecordDetail> RecordDetails { get; set; } = new List<RecordDetail>();
}