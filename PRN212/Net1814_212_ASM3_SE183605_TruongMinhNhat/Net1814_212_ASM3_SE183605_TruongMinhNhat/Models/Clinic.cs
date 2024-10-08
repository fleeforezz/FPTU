﻿// <auto-generated> This file has been auto generated by EF Core Power Tools. </auto-generated>
#nullable disable
using System;
using System.Collections.Generic;

namespace Net1814_212_ASM3_SE183605_TruongMinhNhat.Models;

public partial class Clinic
{
    public int ClinicId { get; set; }

    public string OwnerName { get; set; }

    public string Name { get; set; }

    public string Address { get; set; }

    public string Contact { get; set; }

    public string Email { get; set; }

    public string Website { get; set; }

    public string ClinicType { get; set; }

    public bool? IsActive { get; set; }

    public string City { get; set; }

    public string Country { get; set; }

    public virtual ICollection<Record> Records { get; set; } = new List<Record>();

    public virtual ICollection<Service> Services { get; set; } = new List<Service>();
}