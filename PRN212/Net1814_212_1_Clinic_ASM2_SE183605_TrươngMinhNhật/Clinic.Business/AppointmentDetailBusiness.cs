using Clinic.Business.Base;
using Clinic.Common;
using Clinic.Data.Models;
using Clinic.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clinic.Business
{
    public interface IAppointmentDetailBusiness
    {
        Task<IBusinessResult> GetAll();
        Task<IBusinessResult> GetById(int code);
        Task<IBusinessResult> Save(AppointmentDetail AppointmentDetail);
        Task<IBusinessResult> Update(AppointmentDetail AppointmentDetail);
        Task<IBusinessResult> DeleteById(int code);
    }
    public class AppointmentDetailBusiness : IAppointmentDetailBusiness
    {
        //private readonly AppointmentDetailDAO _DAO;        
        //private readonly AppointmentDetailRepository _AppointmentDetailRepository;
        private readonly UnitOfWork _unitOfWork;

        public AppointmentDetailBusiness()
        {
            //_AppointmentDetailRepository ??= new AppointmentDetailRepository();            
            _unitOfWork ??= new UnitOfWork();
        }

        public async Task<IBusinessResult> GetAll()
        {
            try
            {
                #region Business rule
                #endregion

                //var currencies = _DAO.GetAll();
                //var currencies = await _AppointmentDetailRepository.GetAllAsync();
                var appointmentDetails = await _unitOfWork.AppointmentDetailRepository.GetAllAsync();


                if (appointmentDetails == null)
                {
                    return new BusinessResult(Const.WARNING_NO_DATA_CODE, Const.WARNING_NO_DATA_MSG);
                }
                else
                {
                    return new BusinessResult(Const.SUCCESS_READ_CODE, Const.SUCCESS_READ_MSG, appointmentDetails);
                }
            }
            catch (Exception ex)
            {
                return new BusinessResult(Const.ERROR_EXCEPTION, ex.Message);
            }
        }

        public async Task<IBusinessResult> GetById(int code)
        {
            try
            {
                #region Business rule
                #endregion

                //var AppointmentDetail = await _AppointmentDetailRepository.GetByIdAsync(code);
                var AppointmentDetail = await _unitOfWork.AppointmentDetailRepository.GetByIdAsync(code);

                if (AppointmentDetail == null)
                {
                    return new BusinessResult(Const.WARNING_NO_DATA_CODE, Const.WARNING_NO_DATA_MSG);
                }
                else
                {
                    return new BusinessResult(Const.SUCCESS_READ_CODE, Const.SUCCESS_READ_MSG, AppointmentDetail);
                }
            }
            catch (Exception ex)
            {
                return new BusinessResult(Const.ERROR_EXCEPTION, ex.Message);
            }
        }

        public async Task<IBusinessResult> Save(AppointmentDetail AppointmentDetail)
        {
            try
            {
                //int result = await _AppointmentDetailRepository.CreateAsync(AppointmentDetail);
                int result = await _unitOfWork.AppointmentDetailRepository.CreateAsync(AppointmentDetail);
                if (result > 0)
                {
                    return new BusinessResult(Const.SUCCESS_CREATE_CODE, Const.SUCCESS_CREATE_MSG);
                }
                else
                {
                    return new BusinessResult(Const.FAIL_CREATE_CODE, Const.FAIL_CREATE_MSG);
                }
            }
            catch (Exception ex)
            {
                return new BusinessResult(Const.ERROR_EXCEPTION, ex.ToString());
            }
        }

        public async Task<IBusinessResult> Update(AppointmentDetail AppointmentDetail)
        {
            try
            {
                //int result = await _AppointmentDetailRepository.UpdateAsync(AppointmentDetail);
                int result = await _unitOfWork.AppointmentDetailRepository.UpdateAsync(AppointmentDetail);

                if (result > 0)
                {
                    return new BusinessResult(Const.SUCCESS_UPDATE_CODE, Const.SUCCESS_UPDATE_MSG);
                }
                else
                {
                    return new BusinessResult(Const.FAIL_UPDATE_CODE, Const.FAIL_UPDATE_MSG);
                }
            }
            catch (Exception ex)
            {
                return new BusinessResult(-4, ex.ToString());
            }
        }

        public async Task<IBusinessResult> DeleteById(int code)
        {
            try
            {
                //var AppointmentDetail = await _AppointmentDetailRepository.GetByIdAsync(code);
                var AppointmentDetail = await _unitOfWork.AppointmentDetailRepository.GetByIdAsync(code);
                if (AppointmentDetail != null)
                {
                    //var result = await _AppointmentDetailRepository.RemoveAsync(AppointmentDetail);
                    var result = await _unitOfWork.AppointmentDetailRepository.RemoveAsync(AppointmentDetail);
                    if (result)
                    {
                        return new BusinessResult(Const.SUCCESS_DELETE_CODE, Const.SUCCESS_DELETE_MSG);
                    }
                    else
                    {
                        return new BusinessResult(Const.FAIL_DELETE_CODE, Const.FAIL_DELETE_MSG);
                    }
                }
                else
                {
                    return new BusinessResult(Const.WARNING_NO_DATA_CODE, Const.WARNING_NO_DATA_MSG);
                }
            }
            catch (Exception ex)
            {
                return new BusinessResult(-4, ex.ToString());
            }
        }

    }
}
